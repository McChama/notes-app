const validateNote = NOTE => {
    NOTE.title = NOTE.title.trim();
    NOTE.content = NOTE.content.trim();

    return (NOTE.title.length !== 0 && NOTE.content.length !== 0)
}
export default validateNote;