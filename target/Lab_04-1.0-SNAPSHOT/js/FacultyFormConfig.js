export const facultyFormConfig = {
    inputsDataList: [
        {
            placeholder: "Faculty name",
            name: "facultyName",
            classStyle: "form-control mt-2",
            pattern: "^[A-ZА-Я][a-zA-Zа-яА-Я]*",
            isObligatory: true
        }
    ],
    invisibleInputsDataList: [
        {
            name: "facultyActionType",
            value: "Create"
        }
    ],
    submitButtonConfig: {
        buttonWrapperClassStyle: "d-flex justify-content-center w-100 mt-3",
        buttonClassStyle: "btn btn-success w-25",
        name: null,
        value: null,
        buttonText: "Create Faculty!"
    },
    formOuterDivConfig: {
        divId: "divToMoveItMoveIt",
        divClassStyle: "d-flex flex-column",
        formAction: "university-servlet",
        method: "post"
    }
}