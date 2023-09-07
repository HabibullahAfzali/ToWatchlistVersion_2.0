import { describe, it, expect } from "vitest";
import { mount } from "@vue/test-utils";
import InputForm from "../components/InputForm.vue";

describe(" This test doese two tasks,on the InputForm first check the inputfields if the those are exists return true, then fill those fields with sample data when Add movie button is clicked", () => {
  const tester = mount(InputForm);
  it("renders form fields", async () => {
    expect(tester.find("#title").exists()).toBeTruthy();
    expect(tester.find("#date").exists()).toBeTruthy();
    expect(tester.find("#genre").exists()).toBeTruthy();
    expect(tester.find("#whereToWatch").exists()).toBeTruthy();
  });
  it('saves a film when the "Add movie" button is clicked', async () => {
    // Fill in form fields
    await tester.find("#title").setValue("Titanic");
    await tester.find("#date").setValue("2023");
    await tester.find("#genre").setValue("Action");
    await tester.find("#whereToWatch").setValue("Netflix");

    await tester.find("button").trigger("click");
  });
});
