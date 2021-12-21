import deleteNote from "../api/deleteNote.js";

const removeNote = (noteId) => {
    deleteNote(noteId);
    window.location.reload();
};
export default removeNote;