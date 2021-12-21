const noteForm = note => {
    const form = `
        <div class="container-fluid">
            <div id="title" class="d-flex align-items-center justify-content-between flex-shrink-0 py-3 link-dark text-decoration-none border-bottom">
                <div class="fs-5 fw-semibold" contenteditable="true">
                    ${note.title}
                </div>
                <div class="actions">
                    <button id="modify" type="button" class="btn btn-primary btn-lg btn-floating" data-bs-toggle="tooltip" data-bs-placement="top" title="Save changes" value="${note.id}">
                        <i class="fas fa-save"></i>
                    </button>
                    <button id="delete" type="button" class="btn btn-danger btn-lg btn-floating" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete note" value="${note.id}">
                        <i class="fas fa-eraser"></i>
                    </button>
                    <button id="discard" type="button" class="btn btn-outline-dark btn-lg btn-floating" data-bs-toggle="tooltip" data-bs-placement="top" title="Discard changes">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
            </div>
            <div class="content">
                <div class="d-flex w-100 align-items-center justify-content-between my-2">
                    <small class="text-muted">Created at ${note.createdAt}</small>
                    <small class="text-muted">Last change ${note.updatedAt}</small>
                </div>
                <textarea id="content" class="form-control" maxlength="1024" placeholder="Write your note here" id="floatingTextarea" style="width: 100%; height: 100%; box-sizing: border-box;">${note.content}</textarea>
            </div>
        </div>
    `;
    document.querySelector('#note-form').innerHTML = form;
}
export default noteForm;