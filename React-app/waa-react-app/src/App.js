import { Redirect, Route, Switch} from "react-router";
import "./App.css";
import Admin from "./components/Admin/Admin";
import Dashboard from "./components/Dashboard/Dashboard";
import Header from "./components/Header/Header";
import Login from "./components/Login/Login";
import AddPost from "./components/Post/AddPost/AddPost";

function App() {
   return (
      <div className="App">
      <Header/>
        <Switch>
          <Route exact path="/" component={Login} />
          <Route exact path="/posts" component={Dashboard} />
          <Route exact path="/admin" component={Admin} />
          <Route exact path="/add-post" component={AddPost} />
          {!localStorage.getItem("auth") && <Redirect to="/" />}
        </Switch>
      </div>
  );
}

export default App;
