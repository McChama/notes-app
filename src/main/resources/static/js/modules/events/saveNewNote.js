import postNote from "../api/postNote.js";

const saveNewNote = () => {
    const NOTE = {
        title: document.querySelector("#title").innerText,
        content: document.querySelector("#content").value ,
    }
    postNote(NOTE);
    window.location.reload();
};
export default saveNewNote;