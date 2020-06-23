package operation;

import book.BookList;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList){
        System.out.println("ReturnOpreation");
        System.out.println("输入需要删除书籍的名称");
        String name=scanner.next();


    }
}
