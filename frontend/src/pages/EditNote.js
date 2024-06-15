// src/pages/EditNote.js
import React, { useEffect, useState } from 'react';
import { EditorState, convertFromRaw, convertToRaw } from 'draft-js';
import NoteEditor from '../components/NoteEditor';
import api from '../services/api';

const EditNote = ({ match }) => {
    const [editorState, setEditorState] = useState(EditorState.createEmpty());
    const noteId = match.params.id;

    useEffect(() => {
        const fetchNote = async () => {
            const response = await api.get(`/notes/${noteId}`);
            const contentState = convertFromRaw(JSON.parse(response.data.content));
            setEditorState(EditorState.createWithContent(contentState));
        };

        fetchNote();
    }, [noteId]);

    const saveNote = async (noteContent) => {
        const response = await api.put(`/notes/${noteId}`, { content: noteContent });
        console.log(response.data);
    };

    return (
        <div>
            <h1>Edit Note</h1>
            <NoteEditor editorState={editorState} onSave={saveNote} />
        </div>
    );
};

export default EditNote;
