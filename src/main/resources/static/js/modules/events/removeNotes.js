import deleteNotes from "../api/deleteNotes.js";

const removeNotes = () => {
    deleteNotes();
    window.location.reload();
};
export default removeNotes;