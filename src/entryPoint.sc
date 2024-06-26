require: slotfilling/slotFilling.sc
  module = sys.zb-common
  
# Подключение javascript обработчиков
require: js/getters.js
require: js/reply.js
require: js/actions.js

# Подключение сценарных файлов
require: sc/addRecipe.sc


patterns:
    $AnyText = $nonEmptyGarbage

theme: /
    state: Start
        # При запуске приложения с кнопки прилетит сообщение /start.
        q!: $regex</start>
        # При запуске приложения с голоса прилетит сказанная фраза.
        # Если названме приложения отличается, то выполнится переход к состоянию Fallback, будет проиграно "Я не понимаю".
        # Обратите внимание, что если в названии приложения есть тире, их нужно заменить на пробелы ("my-canvas-test" -> "my canvas test")
        q!: (запусти | открой | вруби) Игровые рецепты
        # q!: Запусти игровые рецепты
        a: Начнём. Данное приложение позволяет просматривать рецепты из игр, сериалов, фильмов и книг. С помощью него можно готовить популярные и экзотические блюда, добавлять свои рецепты и ингредиенты.
        script:
            addSuggestions(["Добавить рецепт картофель", "Помощь"], $context);

    state: Help
        q!: (помощ* | умееш* | можеш*)
        q!: Старт
        a: Данное приложение позволяет просматривать рецепты из игр, сериалов, фильмов и книг. С помощью него можно готовить популярные и экзотические блюда, добавлять свои рецепты и ингредиенты. Для добавления рецепта необходимо ввести наименование рецепта, время готовки, ингредиенты, тег или категорию блюда, описание и шаги готовки.

    state: NoMatch
        event!: noMatch
        a: Команда не распознана. Необходимо повторить, воспользовавшись подсказками.
        script:
            addSuggestions(["Добавить рецепт картофель", "Помощь"], $context);

