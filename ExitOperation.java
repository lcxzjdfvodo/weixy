package operation;

import book.BookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList){
        System.out.println("byebye!");
        System.exit(status:0);

    }
}
