import java.util.Scanner;

/**
 * Расчёт дележа пиратской добычи по правилам.
 * Показывает выгоду капитана при утверждении: "Корабль мой!"
 */
public class HW2_3 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🏴‍☠️ ДЕЛЕЖ ДОБЫЧИ 🏴‍☠️");

        int treasure = readPositiveInt("Введите размер добычи: ");
        int crew = readPositiveInt("Введите количество пиратов (включая капитана): ");

        System.out.printf("\n📊 Общая добыча: %d пиастров%n", treasure);
        System.out.printf("👥 Команда: %d человек%n%n", crew);

        // Расчёт по обычаю
        var regular = splitTreasure(treasure, crew, false);
        System.out.println("--- По обычаю ---");
        printSplit("Владелец", regular.owner, "Капитан", regular.captain, "Пират", regular.pirate);

        // Расчёт при претензии капитана
        var owner = splitTreasure(treasure, crew, true);
        System.out.println("\n--- Капитан: «Корабль мой!» ---");
        printSplit("Владелец", owner.owner, "Капитан", owner.captain, "Пират", owner.pirate);

        int diff = owner.captain - regular.captain;
        System.out.printf("\n🔥 Капитан заработал на этом дополнительно: %d пиастров%n", diff);
    }

    static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n > 0) return n;
                System.out.println("❌ Введите положительное число!");
            } catch (NumberFormatException ignored) {
                System.out.println("❌ Введите целое число!");
            }
        }
    }

    private static SplitResult splitTreasure(int t, int crew, boolean captainIsOwner) {
        int owner = captainIsOwner ? t / 2 : t / 2;
        int remaining = t - owner;
        int captain = remaining / 2;
        int crewShare = (remaining - captain) / crew;
        int captainTotal = captain + crewShare + (captainIsOwner ? owner : 0);
        return new SplitResult(owner, captain, crewShare, captainTotal);
    }

    private static void printSplit(String ownerLabel, int ownerValue,
                                   String captainLabel, int captainValue,
                                   String pirateLabel, int pirateValue) {
        System.out.printf("%s: %d%n", ownerLabel, ownerValue);
        System.out.printf("%s: %d%n", captainLabel, captainValue);
        System.out.printf("%s: %d%n", pirateLabel, pirateValue);
    }

    private record SplitResult(int owner, int captain, int pirate, int captainTotal) {}
}