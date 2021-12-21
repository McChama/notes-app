import { disableSidebarButtons, enableSidebarButtons } from "../events/eventHandler.js";
import sortByTime from "../utils/sortByTime.js";

const notesList = (notes) => {
    let htmlNotes = '';

    if (notes.length === 0) {
        disableSidebarButtons();
        htmlNotes += `
            <div class="list-group-item list-group-item-action py-3 lh-tight">
                <div class="d-flex w-100 align-items-center justify-content-between">
                    <strong class="mb-1">You haven't any notes yet</strong>
                </div>
                <div class="col-10 mb-1 small">
                    To create a note, click on    <i class="fas fa-plus"></i>
                </div>
            </div>
        `;
    }
    else {
        const NOTES = notes.sort(sortByTime);
        
        NOTES.forEach((note, i) => {
            htmlNotes += `
                <div class="list-group-item list-group-item-action py-3 lh-tight" tabindex="${i + 1}" value="${note.id}">
                    <div class="d-flex w-100 align-items-center justify-content-between">
                        <strong class="mb-1">${note.title}</strong>
                        <small class="text-muted">${note.updatedAt}</small>
                    </div>
                    <div class="col-10 mb-1 small">
                        ${note.content}
                    </div>
                </div>
            `;
        });

        enableSidebarButtons();
    }
    document.querySelector('#notes-list').innerHTML = htmlNotes;
};

export default notesList;