import postNote from "../api/postNote.js";
import showAlert from "./showAlert.js";
import validateNote from "../utils/validateNote.js";

const saveNewNote = () => {
    const NOTE = {
        title: document.querySelector("#title").innerText,
        content: document.querySelector("#content").value ,
    }

    if (validateNote(NOTE)){
        postNote(NOTE);
        window.location.reload();
    }
    else
        showAlert('error');
};
export default saveNewNote;