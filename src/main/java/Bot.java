import Models.Lehrer;
import Models.Schueler;
import Models.Stunden;
import Searching.Search;
import gettingDatas.Overwriting_jsonFiles;
import gettingDatas.allStunden;
import gettingDatas.allSchueler;
import gettingDatas.allLehrer;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    List<Stunden> stunden = new ArrayList<>();
    List<Schueler> schueler = new ArrayList<>();
    List<Lehrer> lehrer = new ArrayList<>();

    static String lehrerJSON = "C:\\HTL\\3-Klasse\\NTVS\\BOT\\JSON_Files\\Lehrer.json";
    static String schuelerJSON = "C:\\HTL\\3-Klasse\\NTVS\\BOT\\JSON_Files\\Schueler.json";
    static String stundenJSON = "C:\\HTL\\3-Klasse\\NTVS\\BOT\\JSON_Files\\Stunden.json";

    public static void main(String[] args) throws InterruptedException {

        Overwriting_jsonFiles students = new Overwriting_jsonFiles("https://damp-thicket-86137.herokuapp.com/students", schuelerJSON);
        Overwriting_jsonFiles teachers = new Overwriting_jsonFiles("https://damp-thicket-86137.herokuapp.com/teachers", lehrerJSON);
        Overwriting_jsonFiles lessons = new Overwriting_jsonFiles("https://damp-thicket-86137.herokuapp.com/lessons", stundenJSON);

        students.start();
        teachers.start();
        lessons.start();

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }

    }

    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try{
            setButtons(sendMessage);
            sendMessage(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }


    public void onUpdateReceived(Update update) {
        Search search = new Search();
        try {
            stunden = allStunden.getAllStunden();
            lehrer = allLehrer.getAllLehrer();
            schueler = allSchueler.getAllSchueler();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Message message = update.getMessage();
        if(message != null && message.hasText()){
            switch (message.getText()){
                case "/Schueler":
                case "Schueler":
                    String schuelerStr = "Alle Schueler: \n\n";
                    for (Schueler sc: schueler) {
                        schuelerStr += sc.toString();
                    }
                    sendMsg(message, schuelerStr);
                    break;
                case "/Lehrer":
                case "Lehrer":
                    String lehrerStr = "Alle Lehrer: \n\n";
                    for (Lehrer l: lehrer) {
                        lehrerStr += l.toString();
                    }
                    sendMsg(message, lehrerStr);
                    break;
                case "/Stunden":
                case "Stunden":
                    String stundenStr = "Alle Stunden: \n\n";
                    for (Stunden s: stunden) {
                        stundenStr += s.toString();
                    }
                    sendMsg(message, stundenStr);
                    break;
                case "\uD83D\uDD0E Schueler":
                    sendMsg(message, "Enter the name of Schueler: ");
                    //after getting the answer of user, call the searching function and send the result
                    break;
                case "\uD83D\uDD0E Lehrer":
                    sendMsg(message, "Enter the name of Lehrer: ");
                    //after getting the answer of user, call the searching function and send the result
                    break;
                case "\uD83D\uDD0E Stunden":
                    sendMsg(message, "Enter the name of Stunde: ");
                    //after getting the answer of user, call the searching function and send the result
                    break;
                case "/start":
                    sendMsg(message, "here are all possibilies: \n /Schueler to get all Schuelers \n /Lehrer - to get all Lehrer \n /Stunden - to get all Stunden");
            }
        }
        if(message.isReply() && message.getReplyToMessage().getText().contains("Enter the name of Schueler:")){
            List<Schueler> foundSchueler = search.searchSchueler(message.getText(), schueler);
            String foundSchuelerStr = "Found Schueler: \n\n";
            for (Schueler s: foundSchueler) {
                foundSchuelerStr += s.toString();
            }
            sendMsg(message, foundSchuelerStr);
        }
        if(message.isReply() && message.getReplyToMessage().getText().contains("Enter the name of Lehrer:")){
            List<Lehrer> foundLehrer = search.searchLehrer(message.getText(), lehrer);
            String foundLehrerStr = "Found Lehrer: \n\n";
            for (Lehrer l: foundLehrer) {
                foundLehrerStr += l.toString();
            }
            sendMsg(message, foundLehrerStr);
        }
        if(message.isReply() && message.getReplyToMessage().getText().contains("Enter the name of Stunde:")){
            List<Stunden> foundStunden = search.searchStunden(message.getText(), stunden);
            String foundStundenStr = "Found Stunden: \n\n";
            for (Stunden s: foundStunden) {
                foundStundenStr += s.toString();
            }
            sendMsg(message, foundStundenStr);
        }
    }

    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();

        keyboardRow1.add(new KeyboardButton("Schueler"));
        keyboardRow1.add(new KeyboardButton("Lehrer"));
        keyboardRow1.add(new KeyboardButton("Stunden"));

        keyboardRowList.add(keyboardRow1);
        KeyboardRow keyboardRow2 = new KeyboardRow();

        keyboardRow2.add(new KeyboardButton("\uD83D\uDD0E Schueler"));
        keyboardRow2.add(new KeyboardButton("\uD83D\uDD0E Lehrer"));
        keyboardRow2.add(new KeyboardButton("\uD83D\uDD0E Stunden"));

        keyboardRowList.add(keyboardRow2);


        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public String getBotUsername() {
        return "NTVS_3IT_BOT";
    }

    public String getBotToken() {
        return "1116350594:AAFiISBprTUqr4I7fg_mpEhfPqJ2kEyd6C8";
    }
}
