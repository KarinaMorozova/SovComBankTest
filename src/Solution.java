import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/** 19.07.2022 Karina Morozova
 * В лесу росла голубая колючая американская ель.
 * У ели с четырех сторон ветки разной длины, представленные в виде целого неотрицательного числа.
 * Ель спилили и положили на одну из четырех сторон в грузовик.
 * Пошел обильный снег. Снег выше длины ветки - высыпается.
 * Нужно определить, сколько максимум снега останется после снегопада на ели.
 *
 * Минимальные требования
 * Даны 4 массива неотрицательных целых чисел одинакового размера, каждый из которых представляет
 * собой длину веток ели с одной стороны.
 * Нужно написать функцию, которая по указанным четырем массивам выдаст целое число - максимальное
 * количество скопившегося снега на ветках.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        // Ввести имя файла с консоли
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите имя файла");
//        String fileName = scanner.next();

        // Или завести файл в папке с исходником
        String fileName = System.getProperty("user.dir") +
                File.separator + "src" + File.separator + "data.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // Список максимумов
        List<Integer> listOfSums = new ArrayList<>();
        // Считываем данные из файла
        while (reader.ready()) {
            String str = reader.readLine();
            String[] literas = str.trim().split(",");

            // Заводим список для каждой ветки
            List<Integer> branch = new ArrayList<>();
            for (int i = 0; i < literas.length; i++) {
                branch.add(Integer.parseInt(literas[i]));
            }

            // По сумме каждой ветки складываем в список
            listOfSums.add(branch.stream().mapToInt(Integer::intValue).sum());
        }

        // Глобальный максимум и его индекс.
        // Можно взять максимум по коллекции, но нам нужен его индекс, поэтому цикл
        int globalMax = listOfSums.get(0);
        int globalMaxIndex = 0;
        for (int i = 0; i < listOfSums.size(); i++) {
            System.out.println("Количество снега для " + (i + 1) + "-той ветки = " + listOfSums.get(i));
            if (globalMax < listOfSums.get(i)) {
                globalMax = listOfSums.get(i);
                globalMaxIndex = i;
            }
        }
        System.out.println("Максимальное количество снега скапливается на " + (globalMaxIndex + 1)
                + " ветке в количестве = " + globalMax);
    }
}
