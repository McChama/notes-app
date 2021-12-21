const newNote = () => {
    const form = (`
        <div class="container-fluid">
            <div id="title" class="d-flex align-items-center justify-content-between flex-shrink-0 py-3 link-dark text-decoration-none border-bottom">
                <div class="fs-5 fw-semibold" contenteditable="true">
                    Untitled Note
                </div>
                <div class="actions">
                    <button id="save" type="button" class="btn btn-primary btn-lg btn-floating" data-bs-toggle="tooltip" data-bs-placement="top" title="Save changes">
                        <i class="fas fa-save"></i>
                    </button>
                    <button id="discard" type="button" class="btn btn-outline-dark btn-lg btn-floating" data-bs-toggle="tooltip" data-bs-placement="top" title="Discard changes">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
            </div>
            <div class="content">
                <div class="d-flex w-100 align-items-center justify-content-between my-2">
                    <small class="text-muted">Created at --:--:--</small>
                    <small class="text-muted">Last change --:--:--</small>
                </div>
                <textarea id="content" class="form-control" maxlength="255" placeholder="Write your note here" id="floatingTextarea" style="width: 100%; height: 100%; box-sizing: border-box;"></textarea>
            </div>
        </div>
    `);
    document.querySelector('#note-form').innerHTML = form;
}
export default newNote;