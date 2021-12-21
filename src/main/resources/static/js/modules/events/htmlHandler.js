import notesList from "../views/notesList.js";

export const createSidebarHTML = (NOTES) => {
    notesList(NOTES);
}

export const createNoteHTML = (NOTE) => {
    noteForm(NOTE);
}