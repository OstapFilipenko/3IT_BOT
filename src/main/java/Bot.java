import Models.Lehrer;
import Models.Schueler;
import Models.Stunden;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {
    List<Stunden> stunden = new ArrayList<>();
    List<Schueler> schueler = new ArrayList<>();
    List<Lehrer> lehrer = new ArrayList<>();

    public static void main(String[] args){
        Overwriting_jsonFiles students = new Overwriting_jsonFiles("https://damp-thicket-86137.herokuapp.com/students", "C:\\HTL\\3-Klasse\\NTVS\\BOT\\NTVS_3IT_BOT\\src\\main\\resources\\Schueler.json");
        Overwriting_jsonFiles teachers = new Overwriting_jsonFiles("https://damp-thicket-86137.herokuapp.com/teachers", "C:\\HTL\\3-Klasse\\NTVS\\BOT\\NTVS_3IT_BOT\\src\\main\\resources\\Lehrer.json");
        Overwriting_jsonFiles lessons = new Overwriting_jsonFiles("https://damp-thicket-86137.herokuapp.com/lessons", "C:\\HTL\\3-Klasse\\NTVS\\BOT\\NTVS_3IT_BOT\\src\\main\\resources\\Stunden.json");

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
        Message message = update.getMessage();
        if(message != null && message.hasText()){
            switch (message.getText()){
                case "/Schueler":
                case "Schueler":
                    try{
                        schueler = allSchueler.getAllSchueler();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    String schuelerStr = "Alle Schueler: \n\n";
                    for (Schueler sc: schueler) {
                        schuelerStr += sc.toString();
                    }
                    sendMsg(message, schuelerStr);
                    break;
                case "/Lehrer":
                case "Lehrer":
                    try{
                        lehrer = allLehrer.getAllLehrer();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    String lehrerStr = "Alle Lehrer: \n\n";
                    for (Lehrer l: lehrer) {
                        lehrerStr += l.toString();
                    }
                    sendMsg(message, lehrerStr);
                    break;
                case "/Stunden":
                case "Stunden":
                    try {
                        stunden = allStunden.getAllStunden();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String stundenStr = "Alle Stunden: \n\n";
                    for (Stunden s: stunden) {
                        stundenStr += s.toString();
                    }
                    sendMsg(message, stundenStr);
                    break;
                case "/start":
                    sendMsg(message, "here are all possibilies: \n /Schueler to get all Schuelers \n /Lehrer - to get all Lehrer \n /Stunden - to get all Stunden");
            }
        }
    }

    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();

        keyboardRow.add(new KeyboardButton("Schueler"));
        keyboardRow.add(new KeyboardButton("Lehrer"));
        keyboardRow.add(new KeyboardButton("Stunden"));

        keyboardRowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public String getBotUsername() {
        return "NTVS_3IT_BOT";
    }

    public String getBotToken() {
        return "1116350594:AAFiISBprTUqr4I7fg_mpEhfPqJ2kEyd6C8";
    }
}
