import telebot
from config import token

API_TOKEN = token

bot = telebot.TeleBot(API_TOKEN)

f = 0
# Handle '/start' and '/help'
@bot.message_handler(commands=['help', 'start'])
def send_welcome(message):
    bot.reply_to(message, """\\""")


@bot.message_handler(commands=['info'])
def send_welcome(message):
    bot.reply_to(message, """\
        выберете цвет командой /color
выберете номер командой /number""")
    f = 0

@bot.message_handler(commands=['color'])
def send_welcome3(message):
    global f
    global color
    bot.reply_to(message, "ваш цвет?")
    f = 1

@bot.message_handler(commands=['number'])
def send_welcome4(message):
    global f
    global n
    bot.reply_to(message, "ваш номер?")
    f = 2


@bot.message_handler(func=lambda message: True)
def val(message):
    global n
    global color
    if f == 1:
        color = message.text
        bot.reply_to(message, 'ваш цвет: ' + message.text)
    if f == 2:
        n = message.text
        bot.reply_to(message, 'ваш номер: ' + message.text)
    


# Handle all other messages with content_type 'text' (content_types defaults to ['text'])
#@bot.message_handler(func=lambda message: True)
#def echo_message(message):
 #   bot.reply_to(message, message.text)


bot.infinity_polling()
