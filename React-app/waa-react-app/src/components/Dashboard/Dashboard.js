import React from "react";
import Header from "../Header/Header";
import PostList from "../Post/PostList";
import "./Dashboard.css";

export default function Dashboard(props) {
  return (
    <div className="dashboard">
      <PostList />
    </div>
  );
}
