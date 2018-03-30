package sort;

import java.util.Random;

public class TestMultithreadedMergeSort {

    public static void main( String[] args ) {

        int arrSize = 15000000;
        int[] unsorted = new int[arrSize];
        Random randomizer = new Random();

        // Заполняем массив случайными значениями
        for ( int i = 0; i < arrSize; i++ ) {
            unsorted[i] = randomizer.nextInt( 10_000 );
        }

        // Запускаем секундомер
        long startTime = System.nanoTime();

        // Запускаем сортировку в 1 поток
        SimpleMerger sorter = new SimpleMerger( unsorted );
        sorter.sort();

        long endTime = System.nanoTime();

        // Выводим замерянное время в удобочитаемом виде (в секундах), для этого результат в наносекундах делим на
        // единичку с 9 нулями
        StringBuilder logger = new StringBuilder();
        logger.append( "Single Thread Sort: " );
        logger.append( (double)( endTime - startTime ) / 1_000_000_000 );
        logger.append( " seconds" );

        System.out.println( logger.toString() );

        // Выводим несколько элементов из последовательно выбранных отрезков по 1 000 000 элементов,
        // чтобы убедиться, что массив успешно остортировался
        int[] sorted = sorter.getSorted();
        StringBuilder resDumper = new StringBuilder( "Sorted array examples: " );
        for ( int i = 0; i < 15; i++ ) {
            resDumper.append( sorted[i * 1_000_000 + randomizer.nextInt( 50_000 )] );
            resDumper.append( " | " );
        }

        System.out.println( resDumper.toString() );

        // ========== Многопоточный вариант сортировки ============= //

        // Опять засекаем время
        startTime = System.nanoTime();

        // Натравливаем первый поток на несортированный массив (внутри он разделится на еще несколько, пока их
        // общее количество не достигнет указанного в классе MultiMerger значения MAX_THREADS)
        MultiMerger multiMerger = new MultiMerger( unsorted );
        multiMerger.start();
        // Ждем завершения потока
        try {
            multiMerger.join();
        } catch ( Exception e ) {

        }

        // И опять выводим время
        endTime = System.nanoTime();

        StringBuilder logger1 = new StringBuilder( "// +++++++++++++++++++++ //\r\n" );
        logger1.append( "Multi Thread Sort: " );
        logger1.append( (double)( endTime - startTime ) / 1_000_000_000 );
        logger1.append( " seconds" );

        System.out.println( logger1.toString() );

        // а потом опять примеры сортированного массива
        sorted = multiMerger.getSorted();
        StringBuilder resDumper1 = new StringBuilder( "Sorted array examples: " );
        for ( int i = 0; i < 15; i++ ) {
            resDumper1.append( sorted[i * 1_000_000 + randomizer.nextInt( 50_000 )] );
            resDumper1.append( " | " );
        }

        System.out.println( resDumper1.toString() );
    }
}
