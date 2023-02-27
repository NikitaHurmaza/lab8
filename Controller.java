package com.example.lab8;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import  java.util.List;


public class Controller {

    @FXML
    private Button AddToListB;

    @FXML
    private TextArea AddToListList1;

    @FXML
    private Button AlphabetB;

    @FXML
    private TextArea AlphabetList;

    @FXML
    private TextField AuthorT;

    @FXML
    private TextField AuthorTT;

    @FXML
    private TextArea AuthorsList;

    @FXML
    private Button BookListB;

    @FXML
    private TextField BookNameT;

    @FXML
    private Button BooksOfPublishersB;

    @FXML
    private TextArea BooksOfPublishersList;

    @FXML
    private TextField NumberOfPagesT;

    @FXML
    private TextField PriceT;

    @FXML
    private Button PublisherB;

    @FXML
    private TextArea PublisherList;

    @FXML
    private TextField PublisherT;

    @FXML
    private TextField PublisherTT;

    @FXML
    private Button RemoveB;

    @FXML
    private TextArea RemoveList;

    @FXML
    private TextField RemoveT;

    @FXML
    private TextArea SortList;

    @FXML
    private Button Sortb;

    @FXML
    private Button YearB;

    @FXML
    private TextArea YearList;

    @FXML
    private TextField YearOfPublicationT;

    @FXML
    private TextField YearT;
    @FXML
    void list (){
        Logic logic = new Logic();
        AddToListB.setOnAction(event -> {
            boolean success = true;
            String addBook = null;
            String addAuthor = null;
            String addPublisher = null;
            int addYearOfPublication = 0;
            int addNumberOfPages = 0;
            double addPrice = 0;
            try {
                addBook = (BookNameT.getText());
                addAuthor = (AuthorT.getText());
                addPublisher = (PublisherT.getText());
                addYearOfPublication = (Integer.parseInt((YearOfPublicationT.getText())));
                addNumberOfPages= (Integer.parseInt((NumberOfPagesT.getText())));
                addPrice  = (Double.parseDouble(PriceT.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Book> books = logic.fillList();
                AddToListList1.setText(String.valueOf(logic.AddToList(books, addBook, addAuthor, addPublisher, addNumberOfPages, addYearOfPublication, addPrice)));

            }
        });
    }
    @FXML
    void remove() {
        Logic logic = new Logic();
        RemoveB.setOnAction(event -> {
            boolean success = true;
            int index = 0;
            try {
                index = (Integer.parseInt(RemoveT.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Book> list = logic.fillList();
                RemoveList.setText(String.valueOf(logic.remove(list, index)));


            }
        });
    }
    @FXML
    void alphabetsort(){
        Logic logic = new Logic();
        List <Book> books = logic.fillList();
        AlphabetList.setText(String.valueOf(logic.sort(books)));


    }
    @FXML
    void sortByAuthor(){
        Logic logic = new Logic();
        BookListB.setOnAction(event -> {
            boolean success = true;
            String author = null;
            try{
                author =(AuthorTT.getText());
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if(success){
                List<Book> books= logic.fillList();
                AuthorsList.setText(String.valueOf(logic.getBooksByAuthor(books, author )));
            }
        });

    }
    @FXML
    void searchByPublisher(){
        Logic logic = new Logic();
        PublisherB.setOnAction(event -> {
            boolean success = true;
            String publisher = null;
            try {
                publisher =(PublisherTT.getText());
            }catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if(success){
                List<Book> books = logic.fillList();
                PublisherList.setText(String.valueOf(logic.getBooksByPublisher(books,publisher)));

            }
        });
    }
    @FXML
    void searchByYear(){
        Logic logic = new Logic();
        YearB.setOnAction(event -> {
            boolean success = true;
            int yearOfPublishing = 0;
            try{
                yearOfPublishing = Integer.parseInt((YearT.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if(success){
                List<Book> books = logic.fillList();
                YearList.setText(String.valueOf(logic.getBooksAfterYear(books,yearOfPublishing)));
            }
        });
    }
    @FXML
    void getPublishersSort(){
        Logic logic = new Logic();
        List <Book> books = logic.fillList();
        SortList.setText(String.valueOf(logic.getPublishers(books)));
    }
    @FXML
    void eacBookOfPublishers(){
        Logic logic = new Logic();
        List <Book> books = logic.fillList();
        BooksOfPublishersList.setText(String.valueOf(logic.getBooksByPublisherMap(books)));
    }
}



