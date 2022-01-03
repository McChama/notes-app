import API from "../api/api.js";

const updateNotes = () => {
    API.putNotes();
    window.location.reload();
};
export default updateNotes;