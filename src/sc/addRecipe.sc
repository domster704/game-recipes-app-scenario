theme: /

    state: ДобавлениеЭлемента
        q!: (*добав*|*установ*|*запи*|*созда*|*заки*)
            $AnyText::anyText

        random:
            a: Добавлено!
            a: Записано!

        script:
            addNote($parseTree._anyText, $context);
