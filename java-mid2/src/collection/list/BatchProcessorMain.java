package collection.list;

public class BatchProcessorMain {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        // arrayList
        BatchProcessor processor = new BatchProcessor(list);
        processor.logic(50_000);

        // linkedList
        BatchProcessor processor2 = new BatchProcessor(list2);
        processor.logic(50_000);
    }
}