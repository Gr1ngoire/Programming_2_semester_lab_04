export const studentFormConfig = {
    inputsDataList: [
        {
            placeholder: "Student name",
            name: "studentName",
            classStyle: "form-control mt-1",
            pattern: "^[A-ZА-Я][a-zA-Zа-яА-Я]*",
            isObligatory: true
        },
        {
            placeholder: "Student surname",
            name: "studentSurname",
            classStyle: "form-control mt-1",
            pattern: "^[A-ZА-Я][a-zA-Zа-яА-Я]*",
            isObligatory: true
        },
        {
            placeholder: "Student mark book id",
            name: "studentMarkBookId",
            classStyle: "form-control mt-1",
            pattern: "[a-zA-Z]+_\\d+",
            isObligatory: true
        },
        {
            placeholder: "Student average mark",
            name: "studentAverageMark",
            classStyle: "form-control mt-1",
            pattern: "^(\\d+\\.*\\d+)$",
            isObligatory: true
        },
    ],
    invisibleInputsDataList: [

    ],
    submitButtonConfig: {
        buttonWrapperClassStyle: "d-flex justify-content-center w-100 mt-3",
        buttonClassStyle: "btn btn-success w-25",
        name: "actionType",
        value: "Create",
        buttonText: "Create Student!"
    },
    formOuterDivConfig: {
        divId: "divToMoveItMoveIt",
        divClassStyle: "d-flex flex-column",
        formAction: "faculty-servlet",
        method: "post"
    }
}