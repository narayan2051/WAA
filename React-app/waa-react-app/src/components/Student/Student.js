import React, { useState } from "react";
import "./Student.css";

function Student(props) {
  const [hideButton, setHideButton] = useState(false);

  return (
    <div className="student" onClick={()=>setHideButton(!hideButton)}>
      <p>Student</p>
      <p>Id:{props.id}</p>
      <p>Name:{props.name}</p>
      <p>Major:{props.major}</p>
      {hideButton && (
        <div>
          <button>Edit</button>
          <button>Delete</button>
        </div>
      )}
    </div>
  );
}
export default Student;
