const putNotes = async () => {
    return await fetch(`api/bulkUpdate/notes/`, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
};

 export default putNotes;