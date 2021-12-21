import putNotes from "../api/putNotes.js";

const updateNotes = () => {
    putNotes();
    window.location.reload();
};
export default updateNotes;