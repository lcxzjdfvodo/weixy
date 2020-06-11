package operation;

import book.Book;
import book.BookList;

import javax.annotation.processing.SupportedSourceVersion;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList){
        System.out.println("BorrowOperation");
        String name=scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //找这本书 是否存在
        int i=0;
        for (;i<bookList.getSize()){
            System.out.println("没有此书");
            return;
        }
        //2. 它是否被借出 false可以借
        Book book=bookList.getBook(i);
        if (book.isBorrowed){
            System.out.println("已经借出去了");
        if (book.notBorrowed){
            System.out.println("还未借出");
        }
        }
        }
}
