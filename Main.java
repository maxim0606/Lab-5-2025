import functions.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== ТЕСТИРОВАНИЕ МЕТОДОВ toString(), equals(), hashCode(), clone() ===\n");

            // 1. Создаем тестовые данные
            System.out.println("1. СОЗДАНИЕ ТЕСТОВЫХ ФУНКЦИЙ:");

            // ArrayTabulatedFunction
            FunctionPoint[] points1 = {
                    new FunctionPoint(0, 0),
                    new FunctionPoint(1, 1),
                    new FunctionPoint(2, 4),
                    new FunctionPoint(3, 9)
            };
            ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
            System.out.println("   ArrayTabulatedFunction1 создан");

            // LinkedListTabulatedFunction с такими же точками
            LinkedListTabulatedFunction linkedFunc1 = new LinkedListTabulatedFunction(points1);
            System.out.println("   LinkedListTabulatedFunction1 создан");

            // Функции с другими точками
            FunctionPoint[] points2 = {
                    new FunctionPoint(0, 0),
                    new FunctionPoint(1, 2),
                    new FunctionPoint(2, 5)
            };
            ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
            System.out.println("   ArrayTabulatedFunction2 создан");

            // 2. Тестирование toString()
            System.out.println("\n2. ТЕСТИРОВАНИЕ toString():");
            System.out.println("   ArrayFunc1: " + arrayFunc1.toString());
            System.out.println("   LinkedFunc1: " + linkedFunc1.toString());
            System.out.println("   ArrayFunc2: " + arrayFunc2.toString());

            // 3. Тестирование equals()
            System.out.println("\n3. ТЕСТИРОВАНИЕ equals():");
            System.out.println("   arrayFunc1.equals(linkedFunc1): " + arrayFunc1.equals(linkedFunc1));
            System.out.println("   arrayFunc1.equals(arrayFunc2): " + arrayFunc1.equals(arrayFunc2));
            System.out.println("   arrayFunc1.equals(arrayFunc1): " + arrayFunc1.equals(arrayFunc1));
            System.out.println("   arrayFunc1.equals(null): " + arrayFunc1.equals(null));

            // 4. Тестирование hashCode()
            System.out.println("\n4. ТЕСТИРОВАНИЕ hashCode():");
            System.out.println("   arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
            System.out.println("   linkedFunc1.hashCode(): " + linkedFunc1.hashCode());
            System.out.println("   arrayFunc2.hashCode(): " + arrayFunc2.hashCode());

            // Проверка согласованности equals() и hashCode()
            System.out.println("\n   СОГЛАСОВАННОСТЬ equals() и hashCode():");
            System.out.println("   arrayFunc1.equals(linkedFunc1): " + arrayFunc1.equals(linkedFunc1));
            System.out.println("   arrayFunc1.hashCode() == linkedFunc1.hashCode(): " +
                    (arrayFunc1.hashCode() == linkedFunc1.hashCode()));

            // Изменяем точку и проверяем изменение хэш-кода
            ArrayTabulatedFunction arrayFunc1Modified = new ArrayTabulatedFunction(points1);
            arrayFunc1Modified.setPointY(1, 1.001); // Незначительное изменение
            System.out.println("\n   После изменения точки Y[1] с 1.0 на 1.001:");
            System.out.println("   Старый hashCode: " + arrayFunc1.hashCode());
            System.out.println("   Новый hashCode: " + arrayFunc1Modified.hashCode());
            System.out.println("   Хэши различны: " + (arrayFunc1.hashCode() != arrayFunc1Modified.hashCode()));


            // 5. Тестирование clone()
            System.out.println("\n5. ТЕСТИРОВАНИЕ clone():");

            // Клонирование ArrayTabulatedFunction
            ArrayTabulatedFunction arrayClone = arrayFunc1.clone();
            System.out.println("   arrayFunc1.clone().equals(arrayFunc1): " + arrayClone.equals(arrayFunc1));
            System.out.println("   arrayFunc1 == clone: " + (arrayFunc1 == arrayClone));

            // Клонирование LinkedListTabulatedFunction
            LinkedListTabulatedFunction linkedClone = linkedFunc1.clone();
            System.out.println("   linkedFunc1.clone().equals(linkedFunc1): " + linkedClone.equals(linkedFunc1));
            System.out.println("   linkedFunc1 == clone: " + (linkedFunc1 == linkedClone));

            // 6. Проверка глубокого клонирования
            System.out.println("\n6. ПРОВЕРКА ГЛУБОКОГО КЛОНИРОВАНИЯ:");

            // Изменяем оригинальные функции
            arrayFunc1.setPointY(0, 999);
            linkedFunc1.setPointY(0, 888);

            System.out.println("   После изменения оригиналов:");
            System.out.println("   arrayClone.getPointY(0): " + arrayClone.getPointY(0) + " (должно быть 0)");
            System.out.println("   linkedClone.getPointY(0): " + linkedClone.getPointY(0) + " (должно быть 0)");
            System.out.println("   Клоны не изменились: " +
                    (arrayClone.getPointY(0) == 0 && linkedClone.getPointY(0) == 0));

            // 7. Дополнительные проверки
            System.out.println("\n7. ДОПОЛНИТЕЛЬНЫЕ ПРОВЕРКИ:");

            // Проверка с пустой функцией
            ArrayTabulatedFunction emptyArray = new ArrayTabulatedFunction(0, 1, 2);
            ArrayTabulatedFunction emptyArrayClone = emptyArray.clone();
            System.out.println("   Пустая функция: " + emptyArray.toString());
            System.out.println("   Клон пустой функции: " + emptyArrayClone.toString());
            System.out.println("   Пустые функции равны: " + emptyArray.equals(emptyArrayClone));

            System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");

        } catch (Exception e) {
            System.err.println("Ошибка во время тестирования: " + e.getMessage());
            e.printStackTrace();
        }
    }
}