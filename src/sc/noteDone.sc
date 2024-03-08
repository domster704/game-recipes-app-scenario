theme: /
    
    state: ЗаданиеВыполнено
        event!: done
        event!: DONE
        
        script:
            ### Пример обработки сообщения, отправленного из фронтенда с помощью sendData()
            log('context: ' + JSON.stringify($context))
            var eventData = $context && $context.request && $context.request.data && $context.request.data.eventData || {}
            log('eventData: ' + JSON.stringify($context && $context.request && $context.request.data && $context.request.data.eventData))
            $reactions.answer({
                "value": "Ты - " + eventData.value,
            });
            ###
            addSuggestions(["Добавь задачу купить машину"], $context);
        # random: 
            # a: Молодец!
            # a: Красавичк!
            # a: Супер!
        