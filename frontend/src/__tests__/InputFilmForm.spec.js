import { describe, it, expect } from "vitest";
import { mount } from "@vue/test-utils";
import InputForm from "../components/InputForm.vue";

describe(" This test doese two tasks,on the InputForm first check the inputfields if the those are exists return true, then fill those fields with sample data when Add movie button is clicked", () => {
  const wrapper = mount(InputForm);
  it("renders form fields", async () => {
    // Assert that the form fields are rendered
    expect(wrapper.find("#title").exists()).toBeTruthy();
    expect(wrapper.find("#date").exists()).toBeTruthy();
    expect(wrapper.find("#genre").exists()).toBeTruthy();
    expect(wrapper.find("#whereToWatch").exists()).toBeTruthy();
  });
  it('saves a film when the "Add movie" button is clicked', async () => {
    // Fill in form fields
    await wrapper.find("#title").setValue("Movie Title");
    await wrapper.find("#date").setValue("2023");
    await wrapper.find("#genre").setValue("Action");
    await wrapper.find("#whereToWatch").setValue("Netflix");

    await wrapper.find("button").trigger("click");
  });
});
