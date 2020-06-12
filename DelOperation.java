package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList){
        System.out.println("DelOperation");
        System.out.println("输入需要删除书籍的名称");
        String name=scanner.next();
        //不会从booklist--》进行删除-》isBorrowed true

    }
}
