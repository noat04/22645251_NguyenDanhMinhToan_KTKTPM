import decorator_pattern.BasicBorrow;
import decorator_pattern.BorrowService;
import decorator_pattern.BrailleVersionDecorator;
import decorator_pattern.ExtendResourceDecorator;
import factory_method.Book;
import factory_method.BookFactory;
import observer_pattern.LibraryMember;
import observer_pattern.UserObserver;
import singleton_pattern.Library;
import strategy_pattern.SearchByAuthor;
import strategy_pattern.SearchByName;

public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo Thư Viện (Singleton)
        Library myLibrary = Library.getInstance();

        // 2. Đăng ký người dùng theo dõi (Observer)
        UserObserver toan = new LibraryMember("Toàn");
        UserObserver lan = new LibraryMember("Lan");
        myLibrary.subscribe(toan);
        myLibrary.subscribe(lan);

        // 3. Nhập sách mới bằng Nhà máy (Factory Method)
        System.out.println("\n--- NHẬP SÁCH MỚI ---");
        Book book1 = BookFactory.createBook("PAPER", "Design Patterns", "GoF", "IT");
        Book book2 = BookFactory.createBook("EBOOK", "Clean Code", "Robert C. Martin", "IT");

        // Thêm vào thư viện (Sẽ tự động trigger Observer)
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);

        // 4. Tìm kiếm sách (Strategy)
        // Tìm theo tên
        myLibrary.searchBooks(new SearchByName(), "Clean");
        // Đổi chiến lược: Tìm theo tác giả chỉ bằng cách truyền object khác
        myLibrary.searchBooks(new SearchByAuthor(), "GoF");

        // 5. Mượn sách và Thêm tính năng (Decorator)
        System.out.println("\n--- TIẾN HÀNH MƯỢN SÁCH ---");
        // Mượn cơ bản
        BorrowService borrow1 = new BasicBorrow(book1);
        System.out.println(borrow1.getDescription());

        // Mượn sách book2, kèm gia hạn, kèm chữ nổi
        BorrowService borrow2 = new BasicBorrow(book2);
        borrow2 = new ExtendResourceDecorator(borrow2);
        borrow2 = new BrailleVersionDecorator(borrow2);
        System.out.println(borrow2.getDescription());
    }
}
