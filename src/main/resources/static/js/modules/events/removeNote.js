import API from "../api/api.js";

const removeNote = (noteId) => {
    API.deleteNote(noteId);
    window.location.reload();
};
export default removeNote;