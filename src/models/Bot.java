package models;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class Bot extends TelegramLongPollingBot{
	
	public static final String BOT_USERNAME = "ALEX_2016_BOT";
    public static final String BOT_TOKEN = "259260803:AAE0H1m9bXWQeyMS2NzbdYtP7Of50nfjNdE";
    
	@Override
	public String getBotUsername() {
		return BOT_USERNAME;
	}

	@Override
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		if (message.hasText()) {
			SendMessage response = new SendMessage();
			response.setChatId(message.getChatId().toString());
			response.setText("Hello: " + message.getFrom().getUserName());
			try {
                sendMessage(response);
            } catch (TelegramApiException e) {
            	Logger.getGlobal().log(Level.SEVERE, "Error al enviar mensaje al usuario", e);
            }
		}
	}

	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}

	public static void main(String[] args) {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new Bot());
		} catch (TelegramApiException e) {
			Logger.getGlobal().log(Level.SEVERE, "Error al iniciar el bot", e);
		}
	}
}
