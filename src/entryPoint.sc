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
        q!: (запусти | открой | вруби) GameRecipes
        a: Начнём. Данное приложение позволяет просматривать рецепты из игр, сериалов, фильмов и книг. С помощью него можно готовить популярные и экзотические блюда, добавлять свои рецепты и ингредиенты.

        script:
            addSuggestions(["Помощь", "Добавить рецепт"], $context);

    state: Help
            q!: * (*помощ* | умееш* | можеш*) *
            a: Данное приложение позволяет просматривать рецепты из игр, сериалов, фильмов и книг. С помощью него можно готовить популярные и экзотические блюда, добавлять свои рецепты и ингредиенты. Для добавления рецепта необходимо ввести наименование рецепта, время готовки, ингредиенты, тег или категорию блюда, описание и шаги готовки.
        script:
            addSuggestions(["Добавить рецепт"], $context);

    state: Fallback
        event!: noMatch
        script:
            log('entryPoint: Fallback: context: ' + JSON.stringify($context))
        a: Я не понимаю

