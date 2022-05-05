import { CustomForm } from "./CustomForm.js";
import { studentFormConfig } from "./StudentFormConfig.js"

const studentAddFormContainer = document.querySelector("#addStudentContainer");
const addStudentButton = document.querySelector("#addStudentButton");
const facultySource = document.querySelector("#facultyHeadingToUse");

const customStudentFormCreator = new CustomForm(studentFormConfig.inputsDataList, studentFormConfig.invisibleInputsDataList, studentFormConfig.submitButtonConfig, studentFormConfig.formOuterDivConfig);
const studentForm = customStudentFormCreator.build(false, [{name: "studentFaculty", value: facultySource.innerHTML}]);

addStudentButton.addEventListener('click', (event) => {
    const divToMoveItMoveIt = document.querySelector("#divToMoveItMoveIt");
    event.target.dataset.status === "active" ? divToMoveItMoveIt.remove() : studentAddFormContainer.append(studentForm);
    event.target.dataset.status = event.target.dataset.status === "active" ? "inactive" : "active";
    addStudentButton.innerText = addStudentButton.innerText === "Add new student" ? "Cancel" : "Add new student";
    addStudentButton.className = addStudentButton.innerText === "Add new student" ? "btn btn-primary" : "btn btn-danger";
})