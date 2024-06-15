// src/components/NoteEditor.js
import React, { useState } from 'react';
import { Editor, EditorState, RichUtils } from 'draft-js';
import 'draft-js/dist/Draft.css';

const NoteEditor = ({ onSave }) => {
    const [editorState, setEditorState] = useState(EditorState.createEmpty());

    const handleKeyCommand = (command) => {
        const newState = RichUtils.handleKeyCommand(editorState, command);
        if (newState) {
            setEditorState(newState);
            return 'handled';
        }
        return 'not-handled';
    };

    const onBoldClick = () => {
        setEditorState(RichUtils.toggleInlineStyle(editorState, 'BOLD'));
    };

    const saveNote = () => {
        const contentState = editorState.getCurrentContent();
        const noteContent = JSON.stringify(contentState);
        onSave(noteContent);
    };

    return (
        <div>
            <button onClick={onBoldClick}>Bold</button>
            <div className="editor">
                <Editor
                    editorState={editorState}
                    handleKeyCommand={handleKeyCommand}
                    onChange={setEditorState}
                />
            </div>
            <button onClick={saveNote}>Save</button>
        </div>
    );
};

export default NoteEditor;
