const showAlert = (type = "default") => {
    const alerts = {
        'default': `
            <div class="alert fade alert-fixed alert-primary show" id="placement-example" data-mdb-width="250px" data-mdb-autohide="true" data-mdb-position="top-right" data-mdb-delay="5000" role="alert" data-mdb-hidden="true" data-mdb-append-to-body="true" data-mdb-color="primary" style="display: none width: 40vw; top: unset; right: 10px; bottom: 10px; left: unset; transform: unset;">
                lorem
            </div>
        `,
        'error': `
            <div class="alert alert-dismissible fade show alert-danger" role="alert" data-mdb-color="<span">
                The <strong>title</strong> and the <strong>content</strong> of the note must not be empty
              <button type="button" class="btn-close" data-mdb-dismiss="alert" aria-label="Close"></button>
            </div>
        `
    }
    const alertContainer = document.querySelector('#alerts');
    alertContainer.innerHTML = alerts[type];
}
export default showAlert;