import API from "../api/api.js";

const removeNotes = () => {
    API.deleteNotes();
    window.location.reload();
};
export default removeNotes;