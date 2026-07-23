import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './App.css';

function App() {
  const [showBook, setShowBook] = useState(true);
  const [showBlog, setShowBlog] = useState(true);
  const [showCourse, setShowCourse] = useState(true);

  // 1. Element Variable with if/else
  let courseElement;
  if (showCourse) {
    courseElement = <CourseDetails />;
  } else {
    courseElement = <p style={{ color: 'red' }}>Course details are hidden.</p>;
  }

  // 2. Element Variable using Switch Statement (just for variation)
  const getBookElement = () => {
    switch (showBook) {
      case true:
        return <BookDetails />;
      case false:
        return <p style={{ color: 'red' }}>Book details are hidden.</p>;
      default:
        return null;
    }
  };

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Blogger App</h1>
      <hr />

      <div style={{ marginBottom: '20px', display: 'flex', gap: '10px' }}>
        <button onClick={() => setShowBook(!showBook)}>Toggle Book (Switch/Element)</button>
        <button onClick={() => setShowBlog(!showBlog)}>Toggle Blog (Ternary)</button>
        <button onClick={() => setShowCourse(!showCourse)}>Toggle Course (if/else)</button>
      </div>

      <hr />

      {/* Conditional Rendering Method 1: Using Switch / Function return */}
      <div style={{ marginBottom: '20px' }}>
        <h3>1. Conditional Rendering using Switch (Function Return)</h3>
        {getBookElement()}
      </div>

      {/* Conditional Rendering Method 2: Logical && Operator */}
      <div style={{ marginBottom: '20px' }}>
        <h3>2. Conditional Rendering using Logical &&</h3>
        {/* We can also just use showBook && <BookDetails /> directly */}
        {showBook && <p style={{ color: 'green' }}>Book is currently visible!</p>}
      </div>

      {/* Conditional Rendering Method 3: Ternary Operator */}
      <div style={{ marginBottom: '20px' }}>
        <h3>3. Conditional Rendering using Ternary Operator</h3>
        {showBlog ? <BlogDetails /> : <p style={{ color: 'red' }}>Blog details are hidden.</p>}
      </div>

      {/* Conditional Rendering Method 4: Element Variable from if/else */}
      <div style={{ marginBottom: '20px' }}>
        <h3>4. Conditional Rendering using if/else (Element Variable)</h3>
        {courseElement}
      </div>

    </div>
  );
}

export default App;
