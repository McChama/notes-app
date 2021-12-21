import putNote from "../api/putNote.js";

const modifyNote = noteId => {
    const NOTE = {
        id: noteId,
        title: document.querySelector("#title").innerText,
        content: document.querySelector("#content").value,
    }
    putNote(NOTE);
    window.location.reload();
};
export default modifyNote;