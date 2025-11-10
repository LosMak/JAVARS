// iOS Calculator Logic
class Calculator {
    constructor() {
        this.previousOperand = '';
        this.currentOperand = '0';
        this.operation = undefined;
        this.waitingForNewNumber = false;
        this.lastOperation = undefined;
    }

    clear() {
        this.previousOperand = '';
        this.currentOperand = '0';
        this.operation = undefined;
        this.waitingForNewNumber = false;
    }

    appendNumber(number) {
        if (this.waitingForNewNumber) {
            this.currentOperand = '';
            this.waitingForNewNumber = false;
        }

        if (number === '.' && this.currentOperand.includes('.')) {
            return;
        }

        if (this.currentOperand === '0' && number !== '.') {
            this.currentOperand = number;
        } else {
            this.currentOperand += number;
        }
    }

    chooseOperation(operation) {
        if (this.currentOperand === '') return;

        // Если есть предыдущая операция и мы не ждем новое число, выполняем вычисление
        if (this.previousOperand !== '' && this.operation && !this.waitingForNewNumber) {
            this.compute();
        }

        this.operation = operation;
        this.previousOperand = this.currentOperand;
        this.waitingForNewNumber = true;
    }

    compute() {
        // Если нет операции, возможно пользователь хочет повторить последнюю операцию
        if (!this.operation && this.previousOperand !== '') {
            this.operation = this.lastOperation || '+';
        }

        if (this.previousOperand === '' || this.currentOperand === '' || !this.operation) {
            return;
        }

        let computation;
        const prev = parseFloat(this.previousOperand);
        const current = parseFloat(this.currentOperand);

        if (isNaN(prev) || isNaN(current)) {
            this.currentOperand = 'Ошибка';
            this.updateDisplay();
            return;
        }

        switch (this.operation) {
            case '+':
                computation = prev + current;
                break;
            case '−':
                computation = prev - current;
                break;
            case '×':
                computation = prev * current;
                break;
            case '÷':
                if (Math.abs(current) < 1e-10) {
                    this.currentOperand = 'Ошибка';
                    this.updateDisplay();
                    setTimeout(() => this.clear(), 1500);
                    return;
                }
                computation = prev / current;
                break;
            default:
                return;
        }

        if (!isFinite(computation)) {
            this.currentOperand = 'Ошибка';
            this.updateDisplay();
            return;
        }

        this.lastOperation = this.operation;
        this.currentOperand = this.formatNumber(computation);
        this.operation = undefined;
        this.previousOperand = '';
        this.waitingForNewNumber = true;

        this.updateDisplay();
    }

    calculatePercentage() {
        const current = parseFloat(this.currentOperand);
        if (isNaN(current)) return;

        if (this.previousOperand && this.operation && !this.waitingForNewNumber) {
            const prev = parseFloat(this.previousOperand);
            const percentage = (prev * current) / 100;
            this.currentOperand = this.formatNumber(percentage);
        } else {
            this.currentOperand = this.formatNumber(current / 100);
        }
    }

    toggleSign() {
        if (this.currentOperand === '0' || this.currentOperand === '') return;

        if (this.currentOperand.startsWith('-')) {
            this.currentOperand = this.currentOperand.substring(1);
        } else {
            this.currentOperand = '-' + this.currentOperand;
        }
    }

    formatNumber(number) {
        if (isNaN(number) || !isFinite(number)) return 'Ошибка';

        // Обрабатываем очень большие числа
        if (Math.abs(number) > 999999999999) {
            return number.toExponential(3);
        }

        const stringNumber = number.toString();
        const integerDigits = parseFloat(stringNumber.split('.')[0]);
        const decimalDigits = stringNumber.split('.')[1];

        let integerDisplay;
        if (isNaN(integerDigits)) {
            integerDisplay = '';
        } else {
            integerDisplay = integerDigits.toLocaleString('en', {
                maximumFractionDigits: 0
            });
        }

        if (decimalDigits != null) {
            // Ограничиваем количество знаков после запятой
            const limitedDecimals = decimalDigits.length > 8 ? decimalDigits.substring(0, 8) : decimalDigits;
            return `${integerDisplay}.${limitedDecimals}`;
        } else {
            return integerDisplay;
        }
    }

    updateDisplay() {
        const currentOperandElement = document.querySelector('.current-operand');
        const previousOperandElement = document.querySelector('.previous-operand');

        if (currentOperandElement) {
            currentOperandElement.textContent = this.currentOperand;
        }

        if (previousOperandElement) {
            if (this.operation != null && this.previousOperand !== '') {
                const operationSymbol = this.getOperationSymbol(this.operation);
                previousOperandElement.textContent = `${this.previousOperand} ${operationSymbol}`;
            } else {
                previousOperandElement.textContent = '';
            }
        }
    }

    getOperationSymbol(operation) {
        switch (operation) {
            case '+': return '+';
            case '−': return '−';
            case '×': return '×';
            case '÷': return '÷';
            default: return '';
        }
    }
}

// UI Controller
class CalculatorUI {
    constructor() {
        this.calculator = new Calculator();
        this.init();
    }

    init() {
        // Получаем все кнопки с проверкой существования
        const numberButtons = document.querySelectorAll('.btn-number');
        const operationButtons = document.querySelectorAll('.btn-operator');
        const equalsButton = document.querySelector('[data-action="equals"]');
        const clearButton = document.querySelector('[data-action="clear"]');
        const signButton = document.querySelector('[data-action="sign"]');
        const percentButton = document.querySelector('[data-action="percent"]');

        // Назначаем обработчики событий для цифровых кнопок
        numberButtons.forEach(button => {
            if (button) {
                button.addEventListener('click', () => {
                    this.calculator.appendNumber(button.dataset.action);
                    this.calculator.updateDisplay();
                });
            }
        });

        // Назначаем обработчики событий для кнопок операций
        operationButtons.forEach(button => {
            if (button) {
                button.addEventListener('click', () => {
                    this.calculator.chooseOperation(button.dataset.action);
                    this.calculator.updateDisplay();
                });
            }
        });

        // Обработчик кнопки равно будет добавлен позже через setTimeout

        // Обработчик кнопки очистки
        if (clearButton) {
            clearButton.addEventListener('click', () => {
                this.calculator.clear();
                this.calculator.updateDisplay();
            });
        }

        // Обработчик кнопки смены знака
        if (signButton) {
            signButton.addEventListener('click', () => {
                this.calculator.toggleSign();
                this.calculator.updateDisplay();
            });
        }

        // Обработчик кнопки процентов
        if (percentButton) {
            percentButton.addEventListener('click', () => {
                this.calculator.calculatePercentage();
                this.calculator.updateDisplay();
            });
        }

            // Инициализируем дисплей
            this.calculator.updateDisplay();

        // Обработчик кнопки равно добавляется в основном DOMContentLoaded
        if (equalsButton) {
            console.log('НАЙДЕНА КНОПКА РАВНО В init()');
            equalsButton.addEventListener('click', () => {
                console.log('ОБРАБОТЧИК init() ДЛЯ РАВНО');
                this.calculator.compute();
                this.calculator.updateDisplay();
            });
        } else {
            console.error('КНОПКА РАВНО НЕ НАЙДЕНА В init()');
        }

        // Добавляем поддержку клавиатуры
        document.addEventListener('keydown', (e) => {
            this.handleKeyPress(e);
        });

        // Предотвращаем контекстное меню на длинном нажатии
        document.addEventListener('contextmenu', (e) => {
            e.preventDefault();
        });
    }

    handleKeyPress(e) {
        const key = e.key;

        if (key >= '0' && key <= '9' || key === '.') {
            this.calculator.appendNumber(key);
        } else if (key === '+' || key === '-' || key === '*' || key === '/') {
            const operationMap = {
                '+': '+',
                '-': '−',
                '*': '×',
                '/': '÷'
            };
            this.calculator.chooseOperation(operationMap[key]);
        } else if (key === 'Enter' || key === '=') {
            this.calculator.compute();
        } else if (key === 'Escape' || key.toLowerCase() === 'c') {
            this.calculator.clear();
        } else if (key === '%') {
            this.calculator.calculatePercentage();
        }

        this.calculator.updateDisplay();
    }
}

// Глобальная функция для тестирования (вызывается из HTML)
function testEqualsButton() {
    const equalsBtn = document.querySelector('[data-action="equals"]');
    if (equalsBtn) {
        equalsBtn.click();
        return 'Кнопка нажата';
    } else {
        return 'Кнопка не найдена';
    }
}

// Инициализация калькулятора при загрузке страницы
document.addEventListener('DOMContentLoaded', () => {
    const calculatorUI = new CalculatorUI();

    // Дополнительная инициализация кнопки равно после полной загрузки DOM
    setTimeout(() => {
        const equalsButton = document.querySelector('[data-action="equals"]');
        if (equalsButton) {
            equalsButton.onclick = function() {
                calculatorUI.calculator.compute();
                calculatorUI.calculator.updateDisplay();
            };
        }
    }, 200);
});

// Добавляем вибрацию для мобильных устройств
function addVibration() {
    if ('vibrate' in navigator) {
        navigator.vibrate(50);
    }
}

// Расширяем обработчики кнопок для вибрации
document.addEventListener('DOMContentLoaded', () => {
    const buttons = document.querySelectorAll('.btn');
    buttons.forEach(button => {
        button.addEventListener('click', addVibration);
    });
});