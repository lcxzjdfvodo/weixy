package operation;

import book.BookList;

public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList){
        System.out.println("DisplayOperation");
        for (int i=0;i<bookList.getSize();i++){
            System.out.println(bookList.getBook(i));
        }
    }
}
