class CustomForm {
    #inputsDataList
    #invisibleInputsDataList
    #submitButtonConfig
    #formOuterDivConfig

    constructor(inputsDataList, invisibleInputsDataList, submitButtonConfig, formOuterDivConfig) {
        this.#inputsDataList = inputsDataList
        this.#invisibleInputsDataList = invisibleInputsDataList
        this.#submitButtonConfig = submitButtonConfig
        this.#formOuterDivConfig = formOuterDivConfig
    }


    #addBasicInput(placeholder, name, classStyle, pattern, isObligatory) {
        const input = document.createElement("input");
        input.setAttribute("placeholder", placeholder);
        input.setAttribute("name", name);
        input.setAttribute("class", classStyle);
        input.required = !!isObligatory
        input.setCustomValidity("A parameter must be digit and can not be empty");
        input.setCustomValidity("")
        // oninvalid="setCustomValidity('A parameter must be digit and can not be empty');" oninput="setCustomValidity('');"
        return input
    }

    #addInvisibleInput(name, value) {
        const invisibleInput = document.createElement("input");
        invisibleInput.setAttribute("name", name);
        invisibleInput.setAttribute("value", value);
        invisibleInput.style.display = "none";
        return invisibleInput
    }

    #addSubmitButton(buttonWrapperClassStyle, buttonClassStyle, buttonText, name, value) {
        const buttonWrapper = document.createElement("div")
        buttonWrapper.setAttribute("class", buttonWrapperClassStyle)

        const addSubmitButton = document.createElement("button");
        addSubmitButton.setAttribute("class", buttonClassStyle);
        addSubmitButton.setAttribute("type", "submit")
        if (name && value) {
            addSubmitButton.setAttribute("name", name);
            addSubmitButton.setAttribute("value", value);
        }
        addSubmitButton.innerText = buttonText

        buttonWrapper.append(addSubmitButton)
        return buttonWrapper
    }

    build(invisibleStatic, ...rest) {
        const addDiv = document.createElement("div");
        addDiv.setAttribute("id", this.#formOuterDivConfig.divId)
        addDiv.setAttribute("class", this.#formOuterDivConfig.divClassStyle)

        const addForm = document.createElement("form");
        addForm.setAttribute("action", this.#formOuterDivConfig.formAction)
        addForm.setAttribute("method", this.#formOuterDivConfig.method);

        for (const input of this.#inputsDataList) {
            addForm.append(this.#addBasicInput(input.placeholder, input.name, input.classStyle, input.pattern, input.isObligatory))
        }

        if (invisibleStatic) {
            for (const invisibleInput of this.#invisibleInputsDataList) {
                addForm.append(this.#addInvisibleInput(invisibleInput.name, invisibleInput.value))
            }
        } else {
            for (const invisibleInput of rest.invisibleInputsData) {
                addForm.append(this.#addInvisibleInput(invisibleInput.name, invisibleInput.value))
            }
        }

        addForm.append(this.#addSubmitButton(this.#submitButtonConfig.buttonWrapperClassStyle, this.#submitButtonConfig.buttonClassStyle, this.#submitButtonConfig.buttonText, this.#submitButtonConfig.name, this.#submitButtonConfig.value))
        addDiv.append(addForm)
        return addDiv
    }
}