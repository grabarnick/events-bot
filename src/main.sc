require: requirements.sc
  
theme: /

    state: Start
        q!: $regex</start>
        image: https://just-ai.com/ru/wp-content/uploads/sites/3/2021/12/main_page_news_3.png
        a: Привет! Это бот мероприятий Just AI. Здесь вы можете узнать про наши новые события, купить билеты, получить разные скидки и бонусы!

    state: Bye
        intent!: /пока
        a: Пока пока
        
    state: Ask
        intent!: /вопрос
        a: Напишите ваш вопрос:
        go: Question
        
        state: Question
            q: *
            a: Спасибо за ваш вопрос, мы передали его спикеру!
        
            
    state: TicketReturn
        intent!: /возврат
        a: Возврат билетов осуществляется не позднее, чем за 5 дней до начала мероприятия.Деньги вернуться вам в течение 10 дней.
        a: Вы хотите вернуть билет?
        buttons: 
            "Да"
            "Нет"
            
        state: ReturnYes
            q: Да
            a: Для возврата билета введите вашу почту:
            go: ReturnEmail
        
            state: ReturnEmail
                q: * $Email *
                a: Возврат оформлен, ожидайте возврата средств.
                a: Если у вас есть другие вопросы, вы можете задать их здесь.
                
        state: ReturnNo
            a: Ок, спасибо за обращение.
            
    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}