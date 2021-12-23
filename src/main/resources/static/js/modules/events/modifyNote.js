import putNote from "../api/putNote.js";
import validateNote from "../utils/validateNote.js";
import showAlert from "./showAlert.js";

const modifyNote = noteId => {
    const NOTE = {
        id: noteId,
        title: document.querySelector("#title").innerText,
        content: document.querySelector("#content").value,
    }
    if (validateNote(NOTE)){
        putNote(NOTE);
        window.location.reload();
    }
    else
        showAlert('error');
};
export default modifyNote;