import { facultyFormConfig } from "./FacultyFormConfig";

const facultyAddFormContainer = document.querySelector("#addFacultyContainer");
const addFacultyButton = document.querySelector("#addFacultyButton");

const facultyCustomFormCreator = new CustomForm(facultyFormConfig.inputsDataList, facultyFormConfig.invisibleInputsDataList, facultyFormConfig.submitButtonConfig, facultyFormConfig.formOuterDivConfig);
const facultyForm = facultyCustomFormCreator.build(true);

addFacultyButton.addEventListener('click', (event) => {
    const divToMoveItMoveIt = document.querySelector("#divToMoveItMoveIt");
    event.target.dataset.status === "active" ? divToMoveItMoveIt.remove() : facultyAddFormContainer.append(facultyForm);

    event.target.dataset.status = event.target.dataset.status === "active" ? "inactive" : "active";
    addFacultyButton.innerText = addFacultyButton.innerText === "Add new faculty" ? "Cancel" : "Add new faculty";
    addFacultyButton.className = addFacultyButton.innerText === "Add new faculty" ? "btn btn-primary" : "btn btn-danger";
})