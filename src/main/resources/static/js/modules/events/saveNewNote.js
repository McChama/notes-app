import API from "../api/api.js";
import showAlert from "./showAlert.js";
import validateNote from "../utils/validateNote.js";

const saveNewNote = () => {
    const NOTE = {
        title: document.querySelector("#title").innerText,
        content: document.querySelector("#content").value ,
    }

    if (validateNote(NOTE)){
        API.postNote(NOTE);
        window.location.reload();
    }
    else
        showAlert('error');
};
export default saveNewNote;